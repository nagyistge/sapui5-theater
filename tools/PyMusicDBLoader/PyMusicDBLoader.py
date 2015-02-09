#!/usr/bin/env python

import xml.etree.ElementTree as ET

import requests
import argparse
import json

def get_param():
    parser = argparse.ArgumentParser()
    parser.add_argument("-s", "--svc", help="svc URL")
    parser.add_argument("-f", "--filedb", help="music DB file")
    args = parser.parse_args()
    return args.svc, args.filedb


if __name__=='__main__':
    svc_url, fmusicdb = get_param()

    s = requests.Session()

    artist_url = svc_url + "/Artists"
    album_url = svc_url + "/Albums"

    headers = {
        'OData-Version': '4.0',
        'Content-Type': 'application/json',
        'Accept': 'application/json',
        }

    payload = {
        "MusicBrainzArtistID": "Mb7539c32-53e7-4908-bda3-81449c367da6",
        "Name": "Lana Del Rey",
        }

    r = s.post(artist_url, data=json.dumps(payload), headers=headers)
    print "Artist: %s" % r.status_code

    payload = {
        "Compilation": "False",
        "Label": "Unknown",
        "MusicBrainzAlbumID": "sdcds",
        "Rating": "5",
        "Review": "Nice album",
        "Title": "Born to die",
        "YearRelease": "2012",
        }

    r = s.post(album_url, data=json.dumps(payload), headers=headers)
    print "Album1: %s" % r.status_code

    payload = {
        "Compilation": "False",
        "Label": "Unknown",
        "MusicBrainzAlbumID": "sdcds",
        "Rating": "5",
        "Review": "Another nice album",
        "Title": "Ultraviolence",
        "YearRelease": "2014",
        }

    r = s.post(album_url, data=json.dumps(payload), headers=headers)
    print "Album2: %s" % r.status_code

    ref_url = album_url + "/Albums(4L)/Artist/$ref"

    payload = {
        "@odata.id": "Artist(1L)"
        }

    r = s.post(ref_url, data=json.dumps(payload), headers=headers)
    print "Ref: %s" % r.status_code
    print r.text


    #tree = ET.parse('musicdb.xml')
    #root = tree.getroot()
    #print "Albums:"
    #for album in root.findall('album'):
    #    print '\t' + album.find('title').text
    #print
    #print "Artists:"
    #for artist in root.findall('artist'):
    #    print '\t' + artist.find('name').text + ' (' + artist.find('musicBrainzArtistID').text + ')'