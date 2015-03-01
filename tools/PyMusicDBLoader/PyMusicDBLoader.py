#!/usr/bin/env python

import xml.etree.ElementTree as ET

import requests
import argparse
import json

HEADERS = {
    'OData-Version': '4.0',
    'Content-Type': 'application/json',
    'Accept': 'application/json',
}


def get_param():
    parser = argparse.ArgumentParser()
    parser.add_argument("-s", "--svc", help="svc URL")
    parser.add_argument("-f", "--filedb", help="music DB file")
    parser.add_argument("-t", "--test", action='store_true', help="test mode")
    args = parser.parse_args()
    return args.svc, args.filedb, args.test


def get_artists(tree_root):
    artists = {}
    for artist in tree_root.findall('artist'):
        artists[artist.find('name').text] = artist.find('musicBrainzArtistID').text
    return artists


def get_albums(tree_root):
    albums = {}
    for album in tree_root.findall('album'):
        # albums[album.find('title').text] = album.find('musicBrainzAlbumID').text
        albums[album.find('title').text] = album.find('artist').text
    return albums


def post_artists(artist_url, artists):
    artists_uri = {}
    for artist in artists:
        # print artist, artists[artist]
        payload = {
            "Name": artist,
            "MusicBrainzArtistID": artists[artist],
        }
        r = s.post(artist_url, data=json.dumps(payload), headers=HEADERS)
        # print r.text, r.status_code
        ret = json.loads(r.text)
        artists_uri[artist] = ret['d']['__metadata']['uri']
    return artists_uri


def post_albums(artists_uri, album_url, albums):
    albums_uri = {}
    for album in albums:
        print album, albums[album]
        payload = {
            "Title": album,
            # "Compilation": "False",
            # "Label": "Unknown",
            # "MusicBrainzAlbumID": "sdcds",
            # "Rating": "5",
            # "Review": "Nice album",
            # "YearRelease": "2012",
            "ArtistDetails": { "__metadata": { "uri": artists_uri[albums[album]] } },
        }
        print payload
        r = s.post(album_url, data=json.dumps(payload), headers=HEADERS)
        print r.status_code, r.text
        ret = json.loads(r.text)
        albums_uri[album] = ret['d']['__metadata']['uri']
        # new_url = albums_uri[album] + '/ArtistDetails/'
        # print new_url
        # print artists_uri[albums[album]]
        # payload = {
        #    "@odata.id": artists_uri[albums[album]],
        # }
        # r = s.post(new_url, data=json.dumps(payload), headers=HEADERS)
        # print r.text, r.status_code
    return albums_uri


if __name__ == '__main__':
    svc_url, fmusicdb, test_mode = get_param()
    tree = ET.parse(fmusicdb)
    root = tree.getroot()
    s = requests.Session()
    artist_url = svc_url + "/Artists"
    album_url = svc_url + "/Albums"

    artists = get_artists(root)
    albums = get_albums(root)

    artists_uri = post_artists(artist_url, artists)
    albums_uri = post_albums(artists_uri, album_url, albums)