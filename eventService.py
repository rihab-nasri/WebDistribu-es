
from entities import Event
from eventRepo import EventRepository

class EventService:
    def __init__(self, db_url, db_name):
        self.repository = EventRepository(db_url, db_name)

    def get_all_events(self):
        return self.repository.get_all_events()

    def get_event_by_id(self, event_id):
        return self.repository.get_event_by_id(event_id)

    def create_event(self, name, start_date, location):
        event = Event(None, name, start_date, location)
        return self.repository.create_event(event)

   
