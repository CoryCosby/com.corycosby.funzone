// declare variables for the user and opponent's choices and scores
var you;
var yourScore = 0;
var opponent;
var opponentScore = 0;

// create an array of choices for the game
var choices = ["rock", "paper", "scissors"];

// when the page loads, create the choices images and add an event listener for when they're clicked
window.onload = function() {
    for (let i = 0; i < 3; i++) {
        let choice = document.createElement("img");
        choice.id = choices[i];
        choice.src = "/img/" + choices[i] + ".png";
        choice.addEventListener("click", selectChoice);
        document.getElementById("choices").append(choice);
    }
}

// function to handle when the user selects a choice
function selectChoice() {
    // set the user's choice and update the image
    you = this.id;
    document.getElementById("your-choice").src = you + ".png";

    // randomly select the opponent's choice and update the image
    opponent = choices[Math.floor(Math.random() * 3)];
    document.getElementById("opponent-choice").src = opponent + ".png";

    // check for a winner and update the scores and result message
    var resultMessage = "";
    if (you == opponent) {
        yourScore += 1;
        opponentScore += 1;
        resultMessage = "It's a Tie";
    }
    else {
        if (you == "rock") {
            if (opponent == "scissors") {
                yourScore += 1;
                resultMessage = "Paper Beats Rock. You Win!";
            }
            else if (opponent == "paper") {
                opponentScore += 1;
                resultMessage = "Paper Beats Rock. You Lose!";
            }
        }
        else if (you == "scissors") {
            if (opponent == "paper") {
                yourScore += 1;
                resultMessage = "Scissors Beats Paper. You Win!";
            }
            else if (opponent == "rock") {
                opponentScore += 1;
                resultMessage = "Rock Beats Scissors. You Lose!";
            }
        }
        else if (you == "paper") {
            if (opponent == "rock") {
                yourScore += 1;
                resultMessage = "Paper Beats Rock. You Win!";
            }
            else if (opponent == "scissors") {
                opponentScore += 1;
                resultMessage = "Scissors Beats Paper. You Lose!";
            }
        }
    }

    // update the scores and result message on the page
    document.getElementById("your-score").innerText = yourScore;
    document.getElementById("opponent-score").innerText = opponentScore;
    document.getElementById("result-message").innerText = resultMessage;

    // function to save the score to the server when the game ends
    function endGame() {
        // send a POST request to the server with the user's score
        fetch("/save-score", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: `yourScore=${yourScore}`
        })
        .then(response => response.json())
        .then(score => {
            console.log("Score saved:", score);
        });
    }
}

