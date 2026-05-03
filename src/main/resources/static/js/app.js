function ask() {

    let input = document.getElementById("question");
    let q = input.value.trim();

    if (!q) return;

    addMessage(q, "user");
    input.value = "";

    let typing = addMessage("Typing...", "bot");

    // ✅ CALL RULE-BASED API
    fetch("/api/ask?question=" + encodeURIComponent(q))
    .then(res => res.json())
    .then(data => {

        typing.remove();

        let fullResponse = "";
        data.forEach(item => {
            fullResponse += "• " + item + "\n";
        });

        addMessage(fullResponse, "bot");
    })
    .catch(err => {
        typing.innerText = "Error occurred";
    });
}

function addMessage(text, type) {

    let chatBox = document.getElementById("chat-box");

    let msg = document.createElement("div");
    msg.classList.add("message", type);

    msg.innerText = text;

    chatBox.appendChild(msg);
    chatBox.scrollTop = chatBox.scrollHeight;

    return msg;
}

document.getElementById("question").addEventListener("keypress", function(e) {
    if (e.key === "Enter") {
        ask();
    }
});

function askQuick(text) {
    document.getElementById("question").value = text;
    ask();
}

// ✅ Welcome message
window.onload = function () {
    addMessage("Hello 👋 Ask me about voting, timeline or eligibility", "bot");
};