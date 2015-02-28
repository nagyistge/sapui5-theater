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
        albums[album.find('title').text] = album.find('musicBrainzAlbumID').text
    return albums


if __name__ == '__main__':
    svc_url, fmusicdb, test_mode = get_param()
    tree = ET.parse(fmusicdb)
    root = tree.getroot()
    s = requests.Session()

    artists = get_artists(root)
    albums = get_albums(root)

    print artists
    print albums

    for artist in artists:
        print artist, artists[artist]

    artist_url = svc_url + "/Artists"
    
    r = s.post(artist_url, data=json.dumps(payload), headers=HEADERS)

    ###

    artist_url = svc_url + "/Artists"
    album_url = svc_url + "/Albums"

    # r = s.post(artist_url, data=json.dumps(payload), headers=headers)
    # print "Artist: %s" % r.status_code

    payload = {
        "Compilation": "False",
        "Label": "Unknown",
        "MusicBrainzAlbumID": "sdcds",
        "Rating": "5",
        "Review": "Nice album",
        "Title": "Born to die",
        "YearRelease": "2012",
    }

    #r = s.post(album_url, data=json.dumps(payload), headers=headers)
    #print "Album1: %s" % r.status_code

    payload = {
        "Compilation": "False",
        "Label": "Unknown",
        "MusicBrainzAlbumID": "sdcds",
        "Rating": "5",
        "Review": "Another nice album",
        "Title": "Ultraviolence",
        "YearRelease": "2014",
    }

    #r = s.post(album_url, data=json.dumps(payload), headers=headers)
    #print "Album2: %s" % r.status_code

    ref_url = album_url + "/Albums(4L)/Artist/$ref"

    payload = {
        "@odata.id": "Artist(1L)"
    }

    #r = s.post(ref_url, data=json.dumps(payload), headers=headers)
    #print "Ref: %s" % r.status_code
    #print r.text


    #tree = ET.parse('musicdb.xml')
    #root = tree.getroot()
    #print "Albums:"
    #for album in root.findall('album'):
    #    print '\t' + album.find('title').text
    #print
    #print "Artists:"
    #for artist in root.findall('artist'):
    #    print '\t' + artist.find('name').text + ' (' + artist.find('musicBrainzArtistID').text + ')'