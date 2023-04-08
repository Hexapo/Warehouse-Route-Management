from django.db import models

# _____________________Driver_____________________
class Driver(models.Model):
    firstname = models.CharField(max_length=50)
    lastname = models.CharField(max_length=50)
    
    def __str__(self):
        return self.firstname + " " + self.lastname



# _____________________Trasport Vehicle_____________________
class TransportVehicle(models.Model):
    licencePlate = models.CharField(max_length=10)
    
    def __str__(self):
        return self.licencePlate
    
    
    
# _____________________Destination_____________________
class Destination(models.Model):
    clientFirstName = models.CharField(max_length=50)
    clientLastName = models.CharField(max_length=50)
    country = models.CharField(max_length=50)
    city = models.CharField(max_length=50)
    fullAddress = models.TextField(max_length=50)
    zipcode = models.IntegerField()
    
    def __str__(self):
        return self.country + " " + " " + self.city + " " + self.fullAddress + ", " +  str(self.zipcode)
    
    
    
# _____________________Route_____________________
class Route(models.Model):
    destination = models.ForeignKey(Destination, on_delete= models.CASCADE)
    driver = models.ForeignKey(Driver, on_delete= models.CASCADE)
    transportVehicle = models.ForeignKey(TransportVehicle, on_delete= models.CASCADE)

    
    
# _____________________Shipment_____________________ 
class Shipment(models.Model):
    title = models.TextField(max_length=100)
    code = models.CharField(max_length=50)
    barcode = models.IntegerField()
    route = models.ForeignKey(Route, on_delete=models.CASCADE)
    
    def __str__(self):
        return self.code