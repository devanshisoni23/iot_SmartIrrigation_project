#define trigPin 3
#define echoPin 2
//Tech Trends Shameer
//Smart Irrigation System

int sensor_pin= A0;
int output_value;

void setup(){
pinMode(trigPin, OUTPUT);
pinMode(echoPin, INPUT);
  pinMode(7, OUTPUT);
  Serial.begin(9600);
  Serial.println("Reading from the Moisture sensor…");
  delay(2000);
}

void loop()
{
  long duration, distance;
digitalWrite(trigPin, LOW); 
delayMicroseconds(2); 
digitalWrite(trigPin, HIGH);
delayMicroseconds(10); 
digitalWrite(trigPin, LOW);
duration = pulseIn(echoPin, HIGH);
distance = (duration/2) / 29.1; //Sound can travel a distance of 0.03435 
Serial.print("Distance : ");
 Serial.print(distance);
 Serial.println(" cm ");
 delay(1000);

  output_value= analogRead (sensor_pin);
  output_value= map (output_value,550,10,0,100);
  Serial.print("Moisture:");
  Serial.print(output_value);
  Serial.println("%");

  if (output_value<0)
  {
    delay(1000);
    digitalWrite(7, HIGH);
  }

  else
  {
    delay(1000);
    digitalWrite (7,HIGH);  
  }

  delay (1000);
}