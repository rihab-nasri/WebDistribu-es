from datetime import datetime

class Event:
    def __init__(self, id, name, start_date, location):
        self.id = id
        self.name = name
        self.start_date = start_date
        self.location = location