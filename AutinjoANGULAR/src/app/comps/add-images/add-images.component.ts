import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-add-images',
  templateUrl: './add-images.component.html',
  styleUrls: ['./add-images.component.css']
})
export class AddImagesComponent implements OnInit {
  tooManyImagesMessage: string;
  images: File[] = null;
  thumbnail: File = null;

  constructor(private apiService: ApiService, private router: Router, private authService: AuthService) { }

  ngOnInit(): void {
  }

  

  uploadThumbnail(event) {
    this.thumbnail = <File>event.target.files[0];
    const fd = new FormData();
        fd.append("image", this.thumbnail, this.thumbnail.name);
        this.apiService.uploadThumbnail(fd).subscribe(response => { console.log(response)})
  }

  uploadImages(event) {
    console.log(event);
    
    this.images = <File[]>event.target.files;
    if(this.images.length <= 20) {
      this.tooManyImagesMessage = null;

      for(let i = 0 ; i < this.images.length ; i++) {
        const fd = new FormData();
        fd.append("image", this.images[i], this.images[i].name);
        
        this.apiService.uploadImage(fd).subscribe(response => { console.log(response)})
      }
    }
    else {
      this.tooManyImagesMessage = "Možete dodati maksimum 20 slika";
    }
    
    this.router.navigateByUrl("/user/" + this.authService.loggedInUser.idKorisnik);
    
  }

  test(event) {
    console.log(event);
    
  }

}
