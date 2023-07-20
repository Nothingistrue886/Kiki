# -*- coding: utf-8 -*-

import requests
import sys

def get_data_using_api(url, data):
    headers = {
        "Content-Type": "application/json"
    }

    response = requests.post(url, json=data, headers=headers)

    return response.text

if __name__ == "__main__":
    # 设置标准输出的编码为 UTF-8
    if sys.version_info[0] < 3:
        import codecs
        sys.stdout = codecs.getwriter('utf8')(sys.stdout)
    else:
        sys.stdout = open(sys.stdout.fileno(), mode='w', encoding='utf8', buffering=1)

    url = "http://10.10.109.234:9090/api/base-server/loginUser"  # 更改为实际的API接口URL

    data = {
        "username": "apiUser",
        "password": "0f49834edd3544448d962a7044f29805",  # 使用从浏览器复制来的值
        "time": 1675678404330,
        "loginType": 0
    }

    result = get_data_using_api(url, data)
    print(result)
