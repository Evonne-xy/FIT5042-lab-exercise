import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PokemonCrudComponent} from './pokemon-crud/pokemon-crud.component';
import {PokemonDetailComponent} from "./pokeapi/pokemon-detail/pokemon-detail.component";
import {PokemonListComponent} from "./pokeapi/pokemon-list/pokemon-list.component";

const routes: Routes = [
  { path: 'pokemons', component: PokemonListComponent },
  { path: 'crud-app', component: PokemonCrudComponent },
  { path: 'pokemon/:id', component: PokemonDetailComponent },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
