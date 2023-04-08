from django.shortcuts import render
from django.http import Http404
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status

from .models import Driver, TransportVehicle, Destination, Route, Shipment
from .serializers import DriverSerializer, TransportVehicleSerializer, DestinationSerializer, RouteSerializer, ShipmentSerializer





# search a model using private key
def searchModel(Model, pk):
    try:
        return Model.objects.get(pk=pk)
    
    except Model.DoesNotExist:
        raise Http404    

# __________________get a model__________________
def getModel(Model, modelSerializer, pk):
    model = searchModel(Model, pk)
    serializer = modelSerializer(model)
    
    return Response(serializer.data)

# __________________________general methods__________________________
# post method
def postModel(data, modelSerializer):
    serializer = modelSerializer(data=data, many=False)

    if serializer.is_valid():
        serializer.save()
        return Response(serializer.data, status=status.HTTP_201_CREATED)

    return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

# put method
def putModel(Model, modelSerializer, request, pk):
    model = searchModel(Model, pk)
    serializer = modelSerializer(model, data=request.data)
    
    if serializer.is_valid():
        serializer.save()
        return Response(serializer.data)
    
    return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


# delete method
def deleteModel(Model, pk):
    model = searchModel(Model, pk)
    model.delete()
    
    return Response(status=status.HTTP_204_NO_CONTENT)


# _______________________________________________________________
# _______________________class based views_______________________

# __________________Driver__________________
class DriverList(APIView):
    
    def get(self, request, format=None):
        drivers = Driver.objects.all()
        serializer = DriverSerializer(drivers, many=True)
        
        return Response(serializer.data)
    
    
    def post(self, request, format=None):
        return postModel(request.data, DriverSerializer)



class DriverDetail(APIView):

    def get(self, request, pk, format=None):
        return getModel(Driver, DriverSerializer, pk)

    def put(self, request, pk, format=None):
        return putModel(Driver, DriverSerializer, request, pk)

    def delete(self, request, pk, format=None):        
        return deleteModel(Driver, pk)
# ---------------------------------------------------------------


# __________________TransportVehicle__________________
class TransportVehicleList(APIView):
    
    def get(self, request, format=None):
        transportVehicles = TransportVehicle.objects.all()
        serializer = TransportVehicleSerializer(transportVehicles, many=True)
        
        return Response(serializer.data)

    def post(self, request, format=None):
        return postModel(request.data, TransportVehicleSerializer)
    
    
class TransportVehicleDetail(APIView):

    def get(self, request, pk, format=None):
        return getModel(TransportVehicle, TransportVehicleSerializer, pk)

    def put(self, request, pk, format=None):
        return putModel(TransportVehicle, TransportVehicleSerializer, request, pk)

    def delete(self, request, pk, format=None):        
        return deleteModel(TransportVehicle, pk)
    
# ---------------------------------------------------------------    
    
  
# __________________Destination__________________
class DestinationList(APIView):
    
    def get(self, request, format=None):
        destinations = Destination.objects.all()
        serializer = DestinationSerializer(destinations, many=True)
        
        return Response(serializer.data)
    
    def post(self, request, format=None):
        return postModel(request.data, DestinationSerializer)   
    
    
class DestinationDetail(APIView):

    def get(self, request, pk, format=None):
        return getModel(Destination, DestinationSerializer, pk)

    def put(self, request, pk, format=None):
        return putModel(Destination, DestinationSerializer, request, pk)

    def delete(self, request, pk, format=None):        
        return deleteModel(Destination, pk)
    
# --------------------------------------------------------------- 
    

# __________________Route__________________
class RouteList(APIView):
    
    def get(self, request, format=None):
        routes = Route.objects.all()
        serializer = RouteSerializer(routes, many=True)
        
        return Response(serializer.data)
    
    def post(self, request, format=None):
        return postModel(request.data, RouteSerializer)   
    
    
class RouteDetail(APIView):

    def get(self, request, pk, format=None):
        return getModel(Route, RouteSerializer, pk)

    def put(self, request, pk, format=None):
        return putModel(Route, RouteSerializer, request, pk)

    def delete(self, request, pk, format=None):        
        return deleteModel(Route, pk)
    
# --------------------------------------------------------------- 
    
# __________________Shipment__________________
class ShipmentList(APIView):
    
    def get(self, request, format=None):
        shipments = Shipment.objects.all()
        serializer = ShipmentSerializer(shipments, many=True)
        
        return Response(serializer.data)
    
    
    def post(self, request, format=None):
        return postModel(request.data, ShipmentSerializer)
    
    
class ShipmentDetail(APIView):

    def get(self, request, pk, format=None):
        return getModel(Shipment, ShipmentSerializer, pk)

    def put(self, request, pk, format=None):
        return putModel(Shipment, ShipmentSerializer, request, pk)

    def delete(self, request, pk, format=None):        
        return deleteModel(Shipment, pk)
# ---------------------------------------------------------------