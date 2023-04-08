from django.urls import path
from .views import DriverList, DriverDetail, TransportVehicleList, TransportVehicleDetail, DestinationList, DestinationDetail, RouteList, RouteDetail, ShipmentList, ShipmentDetail

urlpatterns = [
    path('drivers/', DriverList.as_view()),
    path('drivers/<int:pk>/', DriverDetail.as_view()),
    
    
    path('transports/', TransportVehicleList.as_view()),
    path('transports/<int:pk>/', TransportVehicleDetail.as_view()),
    
    path('destinations/', DestinationList.as_view()),
    path('destinations/<int:pk>/', DestinationDetail.as_view()),
    
    path('routes/', RouteList.as_view()),
    path('routes/<int:pk>/', RouteDetail.as_view()),
    
    path('shipments/', ShipmentList.as_view()),
    path('shipments/<int:pk>/', ShipmentDetail.as_view()),
]