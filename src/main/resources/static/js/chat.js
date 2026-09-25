async function sendMessage() {

    const input = document.getElementById("message");

    const message = input.value.trim();

    if (message === "") {
        return;
    }

    addMessage("You", message);

    input.value = "";

    const response = await fetch("/api/chat", {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({
            message: message
        })
    });

    const data = await response.json();

    addMessage("Bot", data.response);
}


function addMessage(sender, message) {

    const chatBox = document.getElementById("chatBox");

    const messageElement = document.createElement("div");

    messageElement.classList.add("message");

    if (sender === "You") {
        messageElement.classList.add("user-message");
    } else {
        messageElement.classList.add("bot-message");
    }

    messageElement.innerHTML =
        "<strong>" + sender + "</strong><br>" + message;

    chatBox.appendChild(messageElement);

    chatBox.scrollTop = chatBox.scrollHeight;
}