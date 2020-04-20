function delQuestion(pageIndex, QuestionID) {
    result = confirm("Are you sure to delete this question ?");
    //click "OK"
    if (result)
        window.location.replace("manageQuiz?index=" + pageIndex + "&delID=" + QuestionID);
}

function countDown(time) {
    myVar = setInterval(function () {
        time--;
        var minute = Math.floor(time / 60);
        var sec = time % 60;

        //stop countdown
        if (time === 0) {
//            document.getElementById("quizForm").submit();
            clearInterval(myVar);
        }

        document.getElementById("timeDisplay").innerHTML = minute + ":" + sec;
    }, 1000);
}





this.currentQuiz = -1;
this.currentDiv = null;
function nextQuestion(numOfQuiz ) {
    //next quiz
    currentQuiz = (currentQuiz + 1) % numOfQuiz;
    
    if (currentDiv !== null) {
        currentDiv.classList.add("hidden");
    }
    //get current quiz
    currentDiv = document.getElementById("q" + currentQuiz);
    //show quiz
    currentDiv.classList.remove("hidden");
    
    document.getElementById("currentQuiz").innerHTML = "Question: " + (currentQuiz + 1) + "/" + numOfQuiz;
}

