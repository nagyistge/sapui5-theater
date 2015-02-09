#!/usr/bin/env python

import requests
import json
import xml.etree.ElementTree as ET

if __name__=='__main__':
    odata_svc = 'https://sapui5theateri305327trial.hanatrial.ondemand.com/sapui5-theater-web/theater.svc/'
    s = requests.Session()
    artist_url = odata_svc + "/Artists"

    headers = {
        'OData-Version': '4.0',
        'Content-Type': 'application/json',
        'Accept': 'application/json',
        }

    payload = {
        #"Id": "1",
        "MusicBrainzArtistID": "Mb7539c32-53e7-4908-bda3-81449c367da6",
        "Name": "Lana Del Rey",
        }

    r = s.post(artist_url, data=json.dumps(payload), headers=headers)
    print r.status_code, r.text

    tree = ET.parse('musicdb.xml')
    root = tree.getroot()
    #print "Albums:"
    #for album in root.findall('album'):
    #    print '\t' + album.find('title').text
    #print
    print "Artists:"
    for artist in root.findall('artist'):
        print '\t' + artist.find('name').text + ' (' + artist.find('musicBrainzArtistID').text + ')'