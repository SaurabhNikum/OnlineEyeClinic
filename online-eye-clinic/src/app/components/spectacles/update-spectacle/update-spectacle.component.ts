import { Component, OnInit } from '@angular/core';
import { Spectacle } from '../../../class/spectacle';
import { SpectacleService } from '../../../services/spectacle.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-spectacle',
  templateUrl: './update-spectacle.component.html',
  styleUrls: ['./update-spectacle.component.css']
})
export class UpdateSpectacleComponent implements OnInit {

  constructor(private route: ActivatedRoute,private spectacleService:SpectacleService,private router:Router) { }

  id:number;
  spectacle:Spectacle=new Spectacle();

  ngOnInit(): void 
  {
    this.id = this.route.snapshot.params['id'];
    this.spectacleService.getSpectacleById(this.id).subscribe(data=>
      {this.spectacle=data;},
      error=>console.log(error));
  }

  onSubmit()
  {
    this.spectacleService.updateSpectacle(this.id,this.spectacle).subscribe();
    alert("Updated successfully")
    this.goToSpectacleDetails();
  }

  goToSpectacleDetails()
  {
    this.router.navigate(['/spectacle-details',this.id]);
  }

}
