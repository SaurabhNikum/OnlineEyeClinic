import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Doctor } from 'src/app/class/doctor';
import { DoctorService } from 'src/app/services/doctor.service';

@Component({
  selector: 'app-doctor-details',
  templateUrl: './doctor-details.component.html',
  styleUrls: ['./doctor-details.component.css']
})
export class DoctorDetailsComponent implements OnInit {

  id:number;
  doctor:Doctor=new Doctor();

  constructor(private route: ActivatedRoute,private doctorService:DoctorService,private router:Router) { }

  ngOnInit(): void 
  {
    this.id = this.route.snapshot.params['id'];
    this.doctorService.getDoctorById(this.id).subscribe(data=>this.doctor=data);
  }

  goToDoctorList(){
    this.router.navigate(['doctor-list']);
  }

  updateDoctor(id:number)
  {
    this.router.navigate(['update-doctor', id]);
  }

  deleteDoctor(id:number)
  {
    this.doctorService.deleteDoctor(id).subscribe(
      ()=>{
        alert("Doctor has deleted successfully");
        this.goToDoctorList();
      },
      error=>console.log(error)
    );
  }


}
