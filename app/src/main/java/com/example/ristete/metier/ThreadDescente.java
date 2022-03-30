package com.example.ristete.metier;

public class ThreadDescente extends Thread
{
    private Ristete tetris;

    private boolean estStoppe;

    public ThreadDescente( Ristete t )
    {
        this.tetris    = t;
        this.estStoppe = false;
    }

    // toutes les 2 secondes, on descend la pièce d'une case
    public void run()
    {
        while( !estStoppe )
        {
            try                  { Thread.sleep( 2000 );          }  // On fait une pause de 2 sec
            catch( Exception e ) { this.estStoppe = true; return; }

            this.tetris.allerEnBas();
            //this.tetris.maj();
        }
    }
}
