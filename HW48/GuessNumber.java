/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

import cs1.Keyboard;

public class GuessNumber 
{
    //instance vars
    private int _lo, _hi, _guessCtr, _target;


    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:  
      post: _lo is lower bound, _hi is upper bound,
      _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) 
    {
	_lo = a;
	_hi = b;
	_guessCtr = 1;
	_target = (int) (Math.random() * (b - a - 1) + a);
    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
      Uses recursion.
      pre:  
      post: 
      ==================================================*/
    public void playRec() 
    {
	int guess;
	System.out.print("Guess a number from " + _lo + " to " + _hi + ": ");
	guess = Keyboard.readInt();
	if (guess == _target) {
	    System.out.println("Correct! It took " + _guessCtr + " guesses.");
	    return;
	}
	else if (guess > _hi || guess < _lo) {
	    System.out.println("Please enter a value within the range :)");
	    playRec();
	}
	else if (guess > _target) {
	    System.out.println("Too high, try again...");
	    _hi = guess - 1;
	}
	else {
	    System.out.println("Too low, try again...");
	    _lo = guess + 1;
	}
	_guessCtr++;
	playRec();
    }


    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
      Uses iteration.
      pre:  
      post: 
      ==================================================*/
    public void playIter() 
    {
	int guess;
	while (true) {
	    System.out.print("Guess a number from " + _lo +
			     " to " + _hi + ": ");
	    guess = Keyboard.readInt();
	    if (guess == _target) { break; }
	    else if (guess > _hi || guess < _lo) {
		System.out.println("Please enter a value within the range :)");
		continue;
	    }
	    else if (guess > _target) {
		System.out.println("Too high, try again...");
		_hi = guess - 1;
	    }
	    else {
		System.out.println("Too low, try again...");
		_lo = guess + 1;
	    }
	    _guessCtr++;
	}
	System.out.println("Correct! It took " + _guessCtr + " guesses.");
    }


    //wrapper for playRec/playIter to simplify calling
    public void play() 
    { 
	//use one or the other below:
	//playRec();
	playIter();
    }


    //main method to run it all
    public static void main( String[] args ) 
    {

	//instantiate a new game
	GuessNumber g = new GuessNumber(1,100);

	//start the game
	g.play();
	// You only really NEED 7 guesses (max)
    }//end main

}//end class
