
from flask import Flask, request, jsonify
from eventService import EventService
import config 
from pymongo import MongoClient

app = Flask(__name__)
client = MongoClient('mongodb://localhost:27017/')
db = client['RH']
collection = db['votre_collection']
app.config.from_pyfile('config.py')

event_service = EventService(app.config['DB_URL'], app.config['DB_NAME'])



@app.route('/evenements', methods=['GET'])
def get_evenements():
    events = event_service.get_all_events()
    return jsonify(events), 200

@app.route('/evenements/<event_id>', methods=['GET'])
def get_evenement(event_id):
    event = event_service.get_event_by_id(event_id)
    if event:
        return jsonify(event), 200
    return 'Événement non trouvé', 404

@app.route('/evenements', methods=['POST'])
def create_evenement():
    data = request.get_json()
    event_id = event_service.create_event(data['name'], data['start_date'], data['location'])
    return str(event_id), 201



if __name__ == '__main__':
    app.run(debug=True)
