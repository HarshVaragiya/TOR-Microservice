from flask import Flask, jsonify, request

app = Flask(__name__)

books = [
    {
        'id': 0,
        'title': 'Permanent Record',
        'description': 'Permanent Record is a 2019 autobiography by Edward Snowden, whose revelations sparked a global debate about surveillance. It was published on September 17, 2019, by Metropolitan Books, an imprint of Henry Holt and Company.', 
        'done': True
    },
    {
        'id': 1,
        'title': 'The Alchemist',
        'description': 'The Alchemist is a novel by Brazilian author Paulo Coelho that was first published in 1988. Originally written in Portuguese, it became a widely translated international bestseller.', 
        'done': False
    }
]

@app.route('/library/get-books', methods=['GET'])
def get_books():
    print("[+] Incoming request from ",request.remote_addr)
    return jsonify(books)

@app.route('/library/get-book-info/<int:book_id>', methods=['GET'])
def get_book_info(book_id):
    print("[+] Incoming request from ",request.remote_addr)
    return jsonify(books[book_id])

if __name__ == '__main__':
    app.run(debug=True,port=8001)