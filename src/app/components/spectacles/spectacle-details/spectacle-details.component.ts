import { Component, OnInit } from '@angular/core';
import { Spectacle } from '../../../class/spectacle';
import { SpectacleService } from '../../../services/spectacle.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-spectacle-details',
  templateUrl: './spectacle-details.component.html',
  styleUrls: ['./spectacle-details.component.css']
})
export class SpectacleDetailsComponent implements OnInit {


  id:number;
  spectacle:Spectacle=new Spectacle();

  constructor(private route: ActivatedRoute,private spectacleService:SpectacleService,private router:Router) { }

  ngOnInit(): void 
  {
    this.id = this.route.snapshot.params['id'];
    this.spectacleService.getSpectacleById(this.id).subscribe(data=>this.spectacle=data);
  }

  goToSpectacleList(){
    this.router.navigate(['/spectacle-list']);
  }

  updateSpectacle(id:number)
  {
    this.router.navigate(['update-spectacle', id]);
  }

  deleteSpectacle(id:number)
  {
    this.spectacleService.deleteSpectacle(id).subscribe(data=>alert("Test has deleted successfully"));
    this.goToSpectacleList();
  }

}
