package com.example.ristete.metier;

public class Cube
{
    private int x;
    private int y;

    private char nom;

    private boolean vivant;

    public Cube( int x, int y, char nom )
    {
        this.x = x;
        this.y = y;

        this.nom = nom;

        this.vivant = true;
    }

    // Accesseurs
    public int getX() { return this.x; }
    public int getY() { return this.y; }

    public char getNom() { return this.nom; }

    public boolean estVivant() { return this.vivant; }

    // Setters
    public void setX( int x ) { this.x = x; }
    public void setY( int y ) { this.y = y; }

    // Met la pièce a "mort", elle n'est plus utilisé
    public void setMort() { this.vivant = false; }

    public String toString()
    {
        return "X";
    }
}
