import { Location } from '@angular/common';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cliente } from 'src/app/modelos/cliente';
import { ClienteService } from 'src/app/servicios/cliente.service';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit, OnDestroy {

  cliente: Cliente = {
    id: 0,
    nombre: '',
    apellidos: '',
    fechaNacimiento: '',
  };

  id: number;

  constructor(
    private clienteService: ClienteService,
    public location: Location,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    console.log('Construyendo formulario')

    //const id: number = +this.route.snapshot.paramMap.get('id');
    this.route.paramMap.subscribe(paramMap => {
      this.id = +paramMap.get('id');
      console.log(this.id);
      if (this.id) {
        this.clienteService.getPorId(this.id).subscribe(cliente => this.cliente = cliente);
      }
    });
  }

  ngOnDestroy(): void {
    console.log('Destruyendo formulario');
  }

  btnAceptar(): void {
    //const ajax = this.id ? this.clienteService.put : this.clienteService.post;

    console.log(this.id, this.cliente);

    if (this.id) {
      this.clienteService.put(this.cliente).subscribe(this.irAListado.bind(this));
    } else {
      this.clienteService.post(this.cliente).subscribe(this.irAListado.bind(this));
    }
  }

  irAListado() {
    this.router.navigate(['/listado']); //this.location.back()
  }

}
