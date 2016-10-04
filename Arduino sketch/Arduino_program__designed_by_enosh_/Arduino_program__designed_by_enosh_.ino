//Code designed by Lakshan Enosh
//enosh.94@hotmail.com

#include "etherShield.h"
#include "ETHER_28J60.h"
#include <Servo.h> 
#include <MultiShiftRegister.h>
 
Servo myservo;
int latchpin = 7;
int datapin = 8;
int clockpin = 9;

int inputPin  = 2;
int pirState = LOW;
int val = 0;
int pinSpeaker  = 5;

int sensorPin = A5;
int sensorValue = 0;

int tval;
int tempPin = A4;

byte data = 0b00000000;
MultiShiftRegister msr(3, latchpin, clockpin, datapin);

static uint8_t mac[6] = {0xAA, 0xBB, 0xCC, 0xDD, 0xBB, 0xAA};                
static uint8_t ip[4] = {192, 168, 8, 106};
static uint16_t port = 80;

ETHER_28J60 e;

void setup()
{
e.setup(mac, ip, port);  
pinMode(latchpin, OUTPUT);
pinMode(datapin, OUTPUT);
pinMode(clockpin, OUTPUT);
pinMode(inputPin, INPUT);
pinMode(pinSpeaker, OUTPUT);
Serial.begin(9600);
msr.shift();
myservo.attach(6);
}

void loop()
{
  
  char* params;
  if (params = e.serviceRequest())
  {
        if(strcmp(params, "?cmd=1")==0)
    {
      myservo.write(-15); 
    }
    
       if(strcmp(params, "?cmd=2")==0)
    {
      myservo.write(40); 
    }
//-----------------------------------------------------------------  
if (strcmp(params, "?cmd=3") == 0)
    {
      msr.set_shift(1);
    }
    
    if (strcmp(params, "?cmd=4") == 0)
    {
      msr.clear_shift(1);   
    }
//-----------------------------------------------------------------
if (strcmp(params, "?cmd=5") == 0)
    {
      msr.set_shift(2);
                                                    //for(int pin=0; pin<=23; pin +=1)
                                                    //{
                                                    // msr.set_shift(pin);
                                                    //delay(100);
                                                    //}
    }
    
    if (strcmp(params, "?cmd=6") == 0)
    {
      msr.clear_shift(2);
                                                     //for(int pin=23; pin>=0; pin -=1)
                                                     //{
                                                     // msr.clear_shift(pin);
                                                     //delay(100);
                                                     // }
    }  
//-----------------------------------------------------------------

    if (strcmp(params, "?cmd=7") == 0)
    {
      msr.set_shift(3);
    }
    
    if (strcmp(params, "?cmd=8") == 0)
    {
      msr.clear_shift(3);   
    }
//----------------------------------------------------------------- 

    if (strcmp(params, "?cmd=9") == 0)
    {
      msr.set_shift(4);
    }
    
    if (strcmp(params, "?cmd=10") == 0)
    {
      msr.clear_shift(4);   
    }
//------------------------------------------------------------------

    if (strcmp(params, "?cmd=11") == 0)
    {
      msr.set_shift(5);
    }
    
    if (strcmp(params, "?cmd=12") == 0)
    {
      msr.clear_shift(5);   
    }
//----------------------------------------------------------------- 

    if (strcmp(params, "?cmd=13") == 0)
    {
      msr.set_shift(6);
    }
    
    if (strcmp(params, "?cmd=14") == 0)
    {
      msr.clear_shift(6);   
    }
//----------------------------------------------------------------- 

    if (strcmp(params, "?cmd=15") == 0)
    {
      msr.set_shift(7);
    }
    
    if (strcmp(params, "?cmd=16") == 0)
    {
      msr.clear_shift(7);   
    }
//----------------------------------------------------------------- 

    if (strcmp(params, "?cmd=17") == 0)
    {
      msr.set_shift(9);
    }
    
    if (strcmp(params, "?cmd=18") == 0)
    {
      msr.clear_shift(9);   
    }
//----------------------------------------------------------------- 

    if (strcmp(params, "?cmd=19") == 0)
    {
      msr.set_shift(10);
    }
    
    if (strcmp(params, "?cmd=20") == 0)
    {
      msr.clear_shift(10);   
    }
//----------------------------------------------------------------- 

    if (strcmp(params, "?cmd=21") == 0)
    {
      msr.set_shift(12);
    }
    
    if (strcmp(params, "?cmd=22") == 0)
    {
      msr.clear_shift(12);   
    }
//----------------------------------------------------------------- 

    if (strcmp(params, "?cmd=23") == 0)
    {
      msr.set_shift(13);
    }
    
    if (strcmp(params, "?cmd=24") == 0)
    {
      msr.clear_shift(13);   
    }
//----------------------------------------------------------------- 

    if (strcmp(params, "?cmd=25") == 0)
    {
      msr.set_shift(14);
    }
    
    if (strcmp(params, "?cmd=26") == 0)
    {
      msr.clear_shift(14);   
    }
//----------------------------------------------------------------- 

    if (strcmp(params, "?cmd=27") == 0)
    {
      msr.set_shift(15);
    }
    
    if (strcmp(params, "?cmd=28") == 0)
    {
      msr.clear_shift(15);   
    }
//-----------------------------------------------------------------

    if (strcmp(params, "?cmd=29") == 0)
    {
      tval = analogRead(tempPin);
      float mv = ( tval/1024.0)*5000; 
      float cel = mv/10;
      float farh = (cel*9)/5 + 32;

      Serial.print("TEMPRATURE = ");
      Serial.print(cel);
      Serial.print("*C");
      Serial.println();
      delay(1000);
      tval = analogRead(tempPin);
    }
    
    if (strcmp(params, "?cmd=30") == 0)
    {
      msr.clear_shift(16);   
    }
//----------------------------------------------------------------- 
    if (strcmp(params, "?cmd=31") == 0)
    {
    sensorValue = analogRead(sensorPin);
    while(sensorValue>500)
    {
      sensorValue = analogRead(sensorPin);
      msr.set_shift(13);
      delay(sensorValue);
      msr.clear_shift(13); 
      msr.set_shift(14);
      delay(sensorValue);
      msr.clear_shift(14); 
      msr.set_shift(15);
      delay(sensorValue);
      msr.clear_shift(15);
      sensorValue = analogRead(sensorPin);
    }
    }
    
    if (strcmp(params, "?cmd=32") == 0)
    {
      msr.clear_shift(13); 
      msr.clear_shift(14); 
      msr.clear_shift(15);   
    }
//----------------------------------------------------------------- 

    if (strcmp(params, "?cmd=33") == 0)
    {
     val = digitalRead(inputPin);  // read input value
  if (val == HIGH) {            // check if the input is HIGH
    playTone(300, 160);
    //delay(150);

    
    //if (pirState == LOW) {
      // we have just turned on
      //Serial.println("Motion detected!");
      // We only want to print on the output change, not state
      //pirState = HIGH;
    //}
  } //else {
      //playTone(0, 0);
      //delay(300);    
     // if (pirState == HIGH){
      // we have just turned off
      //Serial.println("Motion ended!");
      // We only want to print on the output change, not state
      //pirState = LOW;
    //}
  //}
    }
    
    if (strcmp(params, "?cmd=34") == 0)
    {
      msr.clear_shift(17);   
    }
//----------------------------------------------------------------- 
    e.respond();
  }
  }

  //------------------------------------------------- end of loop

  void playTone(long duration, int freq) {
    duration *= 1000;
    int period = (1.0 / freq) * 1000000;
    long elapsed_time = 0;
    while (elapsed_time < duration) {
        digitalWrite(pinSpeaker,HIGH);
        delayMicroseconds(period / 2);
        digitalWrite(pinSpeaker, LOW);
        delayMicroseconds(period / 2);
        elapsed_time += (period);
    }
}

