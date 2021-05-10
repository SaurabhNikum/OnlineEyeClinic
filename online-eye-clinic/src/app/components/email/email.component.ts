import { Time } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmailService } from 'src/app/services/email.service';

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrls: ['./email.component.css']
})
export class EmailComponent implements OnInit {

  
data={
  to:"",
  subject:"",
  message:""
}

flag:boolean=false;
date:Date;
time:Time;
  constructor(private email:EmailService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void 
  {
    this.date=this.route.snapshot.params['date'];
    this.time=this.route.snapshot.params['time'];
    this.data.to=this.route.snapshot.params['email'];
    this.data.subject="Appointment request is approved with OnlineEyeClinic";
    this.data.message="Hiii ! Welcome to OnlineEyeClinic, a well known eye care hospital.We are very delighted to inform you that your appointment request with our doctor is accepted..Below are the appointment details:  Appointment Date : "+this.date + " Appointment Time : "+this.time;
  }

  doSubmitForm()
  {
    console.log("try to submit");
    if(this.data.to=='' || this.data.subject=='' || this.data.message=='')
    {
      alert("field cannot be empty");
      return;
    }

    this.flag=true;

    this.email.sendEmail(this.data).subscribe(
      response=>{
        console.log(response);
        this.flag=false;
        alert("Email sent successfully");
        this.router.navigate(['admin-service']);
      },
      error=>{
        console.log(error);
        this.flag=false;
        alert("Error occured")
      }
    )
  }

}
