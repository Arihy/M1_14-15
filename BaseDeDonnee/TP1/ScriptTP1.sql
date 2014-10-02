drop table subvention;
drop table gain;
drop table sponsor;
drop table rencontre;
drop table joueur;

create table joueur
(
	Nom varchar2(20),
	Prenom varchar2(20),
	Age number,
	Nationnalite varchar2(20),
	PRIMARY KEY(Nom)
);

create table rencontre
(
	NomGagnant varchar2(20),
	NomPerdant varchar2(20),
	NomTournoi varchar2(20),
	DateTournoi date,
	Score varchar2(20),
	PRIMARY KEY(NomGagnant, NomPerdant, NomTournoi, DateTournoi),
	FOREIGN KEY(NomGagnant) REFERENCES joueur(Nom),
	FOREIGN KEY(NomPerdant) REFERENCES joueur(Nom)
);

create table sponsor
(
	Nom varchar2(20),
	Adresse varchar2(20),
	ChiffreAffaires number,
	PRIMARY KEY(Nom)
);

create table gain
(
	NomJoueur varchar2(20),
	Annee varchar2(4),
	Prime number,
	NomSponsor varchar2(20),
	PRIMARY KEY(NomJoueur, Annee),
	FOREIGN KEY(NomJoueur) REFERENCES joueur(Nom)
);

create table subvention
(
	NomTournoi varchar2(20),
	Annee varchar2(4),
	NomSponsor varchar2(20),
	Montant number,
	PRIMARY KEY(NomTournoi, Annee, NomSponsor),
	-- Une cle primaire est une cle etranger si c'est la seule cle primaire de la table de reference
	FOREIGN KEY(NomSponsor) REFERENCES sponsor(Nom)
);