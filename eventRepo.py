
from pymongo import MongoClient
from entities import Event

class EventRepository:
    def __init__(self, db_url, db_name):
        self.client = MongoClient(db_url)
        self.db = self.client[db_name]
        self.collection = self.db['events']

    def get_all_events(self):
        events = self.collection.find()
        return [Event(e['_id'], e['name'], e['start_date'], e['location']) for e in events]

    def get_event_by_id(self, event_id):
        event = self.collection.find_one({'_id': event_id})
        if event:
            return Event(event['_id'], event['name'], event['start_date'], event['location'])
        return None

    def create_event(self, event):
        event_data = {
            'name': event.name,
            'start_date': event.start_date,
            'location': event.location
        }
        result = self.collection.insert_one(event_data)
        return result.inserted_id

    
        