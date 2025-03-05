let players = [];
let playerQuestions = {};
let questions = [];
let currentPlayerIndex = 0;
let currentVoterIndex = 0;
let currentQuestion = "";
let votes = {};
let requiredVotes = 0;

function startSetup() {
    const numPlayers = document.getElementById("numberOfPlayers").value;
    requiredVotes = document.getElementById("numberOfVotes").value;

    if (numPlayers < 4 || requiredVotes < 1) {
        alert("Minimum 4 players and at least 1 vote are required.");
        return;
    }

    document.getElementById("setup").style.display = "none";
    const playerInputs = document.getElementById("playerInputs");

    for (let i = 1; i <= numPlayers; i++) {
        playerInputs.innerHTML += `<label>Player ${i}:</label><input type="text" id="player${i}">`;
    }
    document.getElementById("playerNames").style.display = "block";
}

function nextToQuestions() {
    const playerInputs = document.querySelectorAll("#playerInputs input");
    players = Array.from(playerInputs).map(input => input.value.trim()).filter(Boolean);

    if (players.length < 4) {
        alert("Please enter at least 4 player names.");
        return;
    }

    document.getElementById("playerNames").style.display = "none";
    document.getElementById("playerQuestionInput").style.display = "block";
    askPlayerQuestions();
}

function askPlayerQuestions() {
    const playerName = players[currentPlayerIndex];
    document.getElementById("playerQuestionPrompt").innerText = `${playerName}, please enter 3 questions (others, look away):`;

    const questionArea = document.getElementById("individualQuestions");
    questionArea.innerHTML = "";

    for (let i = 1; i <= 3; i++) {
        questionArea.innerHTML += `<label>Question ${i}:</label><input type="text" class="player-question-input"><br>`;
    }
}

function savePlayerQuestions() {
    const questionInputs = document.querySelectorAll(".player-question-input");
    const questions = Array.from(questionInputs).map(input => input.value.trim()).filter(Boolean);

    if (questions.length < 3) {
        alert("Please enter all 3 questions.");
        return;
    }

    playerQuestions[players[currentPlayerIndex]] = questions;

    currentPlayerIndex++;
    if (currentPlayerIndex < players.length) {
        askPlayerQuestions();
    } else {
        finalizeQuestions();
    }
}

function finalizeQuestions() {
    document.getElementById("playerQuestionInput").style.display = "none";

    // Combine all player questions into a single array
    questions = Object.values(playerQuestions).flat();
    document.getElementById("gameArea").style.display = "block";
    nextQuestion();
}

function nextQuestion() {
    if (questions.length === 0) {
        alert("Game Over!");
        location.reload();
        return;
    }

    currentQuestion = questions.splice(Math.floor(Math.random() * questions.length), 1)[0];
    document.getElementById("questionDisplay").innerText = `Who's more likely to ${currentQuestion}?`;

    currentVoterIndex = 0;
    votes = {};
    players.forEach(player => (votes[player] = 0));

    promptNextVoter();
}

function promptNextVoter() {
    const voterName = players[currentVoterIndex];
    document.getElementById("questionDisplay").innerText = `${voterName}, please cast your vote for: "${currentQuestion}"`;

    const voteArea = document.getElementById("voteArea");
    voteArea.innerHTML = "";
    players.forEach(player => {
        voteArea.innerHTML += `<label>${player}</label><input type="radio" name="vote" value="${player}"><br>`;
    });
    voteArea.innerHTML += `<button onclick="submitVote()">Submit Vote</button>`;
}

function submitVote() {
    const selectedVote = document.querySelector('input[name="vote"]:checked');
    if (!selectedVote) {
        alert("You must select a player to vote for.");
        return;
    }

    votes[selectedVote.value]++;
    currentVoterIndex++;

    if (currentVoterIndex < players.length) {
        promptNextVoter();
    } else {
        finalizeVoting();
    }
}

function finalizeVoting() {
    document.getElementById("gameArea").style.display = "none";

    const maxVote = Math.max(...Object.values(votes));
    const mostVoted = Object.keys(votes).find(player => votes[player] === maxVote);

    document.getElementById("results").style.display = "block";

    if (maxVote >= requiredVotes) {
        document.getElementById("resultDisplay").innerText = `${mostVoted} is most likely to ${currentQuestion}.`;
    } else {
        document.getElementById("resultDisplay").innerText = `No one got ${requiredVotes} votes. The answer will not be revealed.`;
    }
}

function nextQuestion() {
    document.getElementById("results").style.display = "none";

    if (questions.length === 0) {
        alert("Game Over! Thanks for playing!");
        location.reload();
    } else {
        nextQuestion();
    }
}
