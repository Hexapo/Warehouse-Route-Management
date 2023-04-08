from django.contrib import admin
from .models import Driver, TransportVehicle, Destination, Route, Shipment


admin.site.register(Driver)
admin.site.register(TransportVehicle)
admin.site.register(Destination)
admin.site.register(Route)
admin.site.register(Shipment)
