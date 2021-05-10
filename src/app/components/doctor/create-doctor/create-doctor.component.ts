import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Doctor } from 'src/app/class/doctor';
import { DoctorService } from 'src/app/services/doctor.service';

@Component({
  selector: 'app-create-doctor',
  templateUrl: './create-doctor.component.html',
  styleUrls: ['./create-doctor.component.css']
})
export class CreateDoctorComponent implements OnInit {

  constructor(private router: Router,private doctorService:DoctorService) { }

  doctor:Doctor=new Doctor();

  ngOnInit(): void {
  }

  saveDoctor()
  {
    this.doctorService.createDoctor(this.doctor).subscribe(data=>{
      console.log(data);
      alert("Doctor has added successfully");
      this.goToDoctorList();

    },
    error=>console.log(error));
  }
  
  goToDoctorList(){
    this.router.navigate(['doctor-list']);
  }

  onSubmit(){
    this.saveDoctor();
  }
}
