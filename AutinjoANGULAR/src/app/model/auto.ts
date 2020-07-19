import { Korisnik } from './korisnik';
import { Slika } from './slika';

export class Auto {
    constructor(
        public idAutomobil: number,
        public cena: number,
        public datumPostavljanja: Date,
        public fiksnaCena: string,
        public godiste: number,
        public gorivo: string,
        public karakteristike: string,
        public karoserija: string,
        public kilometraza: number,
        public ks: number,
        public kubikaza: number,
        public marka: string,
        public model: string,
        public opis: string,
        public oprema: string,
        public sigurnost: string,
        public stanje: string,
        public stanjeLista: string,
        public thumbnailPath: string,
        public zamena: string,
        public korisnik: Korisnik,
        public slikas: Slika[]) {}

       

    }