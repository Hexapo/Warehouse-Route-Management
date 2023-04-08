from rest_framework import serializers
from .models import Driver, TransportVehicle, Destination, Route, Shipment

class DriverSerializer(serializers.ModelSerializer):
    class Meta:
        model = Driver
        fields = '__all__'
    

class TransportVehicleSerializer(serializers.ModelSerializer):
    class Meta:
        model = TransportVehicle
        fields = '__all__'
        
        
class DestinationSerializer(serializers.ModelSerializer):
    class Meta:
        model = Destination
        fields = '__all__'
        
class ShipmentSerializer(serializers.ModelSerializer):
    class Meta:
        model = Shipment
        fields = '__all__'

class RouteSerializer(serializers.ModelSerializer):
    class Meta:
        model = Route
        fields = '__all__'