import { Component, OnInit } from '@angular/core';
import { Spectacle } from '../../../class/spectacle';
import { SpectacleService } from '../../../services/spectacle.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-spectacle-list',
  templateUrl: './spectacle-list.component.html',
  styleUrls: ['./spectacle-list.component.css']
})
export class SpectacleListComponent implements OnInit {

  constructor(private spectacleService:SpectacleService,private router:Router) { }

  spectacles:Spectacle[];
  model:string;

  ngOnInit(): void 
  {
    this.getSpectacle();
  }

  getSpectacle()
  {
    this.spectacleService.getSpectacles().subscribe(data=>this.spectacles=data);
  }

  spectacleByModel()
  {
    this.spectacleService.getSpectacleByModel(this.model).subscribe(data=>this.spectacles=data);
  }

  spectacleDetails(id:number)
  {
    this.router.navigate(['spectacle-details', id]);
  }

  updateSpectacle(id:number)
  {
    this.router.navigate(['update-spectacle', id]);
  }

  deleteSpectacle(id:number)
  {
    this.spectacleService.deleteSpectacle(id).subscribe(
      data=>{alert("Spectacle has deleted successfully");
      this.getSpectacle();},
      error=>{
        console.log(error);
        alert("Deletion failed")
        this.getSpectacle();;}
    );
    
  }

}
