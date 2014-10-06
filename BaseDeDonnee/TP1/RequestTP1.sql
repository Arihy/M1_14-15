SELECT NomJoueur AS Joueur, Prime FROM gain
WHERE NomSponsor = 'Peugeot' AND Annee >= 2006 AND Annee <= 2010;

SELECT DISTINCT Nom, Age FROM joueur, rencontre
WHERE (Nom = NomGagnant OR Nom = NomPerdant)
AND NomTournoi = 'RG' AND DateTournoi like '%10';

-- a finir
SELECT DISTINCT Nom, Nationnalite FROM joueur, rencontre
WHERE Nom = NomGagnant
AND NomTournoi = 'RG'