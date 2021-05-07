import os
import sys
import requests
client_id = "vgahoraqwl"
client_secret = "lfOaoMj49s5i52qn9eayzImMPSj4YNWtcT6Ssdzz"
url = "https://naveropenapi.apigw.ntruss.com/vision/v1/celebrity" # 유명인 얼굴인식
files = {'image': open("C:/Users/정동현/Desktop/song.jpg", 'rb')}
headers = {'X-NCP-APIGW-API-KEY-ID': client_id, 'X-NCP-APIGW-API-KEY': client_secret }
response = requests.post(url,  files=files, headers=headers)
rescode = response.status_code
if(rescode==200):
    print (response.text)
else:
    print("Error Code:" + rescode)
