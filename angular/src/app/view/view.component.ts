import { Component, OnInit } from '@angular/core';
import { Vendor } from '../vendor';
import { MainserviceService } from '../mainservice.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.scss']
})
export class ViewComponent implements OnInit {

  vendorlist: Vendor[];
  vendor = new Vendor();
  searchString: string;

  constructor(private _mainservice: MainserviceService) { }

  ngOnInit() {
    this.getAllVendors();
  }
  viewAll(): void
  {
    this.getAllVendors();
  }

  getAllVendors(): void {
    this._mainservice.getVendors()
      .subscribe((userData) => {
        this.vendorlist = userData,
          console.log(userData);
      }, (error) => {
        console.log(error);
      });
  }

}



