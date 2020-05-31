from flask import Flask, jsonify, request
import requests

app = Flask(__name__)

LIBRARY_SERVICE_REMOTE_URL = 'http://s7fyhrsrlh44wlbimeyvvqygazaxo3fjfyqpentn4ajxzth6o42tmqid.onion:8001'

sess = requests.Session()
sess.proxies = {
    'http':  'socks5h://127.0.0.1:9050',
    'https': 'socks5h://127.0.0.1:9050'
    }

users = [
    {
        "name":"Harsh",
        "books":[0,1]
    },{
        "name":"Nirav",
        "books":[0]
    }
]

@app.route('/root/get-user/<int:user_id>', methods=['GET'])
def get_book_info(user_id):
    print("[+] Incoming root-request from ",request.remote_addr)

    books_read = []

    for book in users[user_id]["books"]:
        req = sess.get(LIBRARY_SERVICE_REMOTE_URL+'/library/get-book-info/{}'.format(book))
        books_read.append(req.json())

        
    return jsonify({
        "username":users[user_id]["name"],
        "books_read":books_read
    })

if __name__ == '__main__':
    app.run(debug=False,port=8000)