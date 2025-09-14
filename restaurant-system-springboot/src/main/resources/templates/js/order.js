
function placeOrder(username, selectedItems, qty){
    let orders = JSON.parse(localStorage.getItem("orders") || "[]");
    orders.push({
        username,
        items: selectedItems,
        qty,
        date: new Date().toLocaleString(),
        status: "pending"
    });
    localStorage.setItem("orders", JSON.stringify(orders));
}

function displayAdminOrders(){
    let orders = JSON.parse(localStorage.getItem("orders") || "[]");
    let table = document.getElementById("ordersTable");
    orders.forEach((o, index) => {
        if(o.status === "pending"){
            o.items.forEach(item => {
                let row = table.insertRow();
                row.insertCell(0).innerText = o.username;
                row.insertCell(1).innerText = item;
                row.insertCell(2).innerText = o.qty;
                row.insertCell(3).innerText = o.date;
                let cell4 = row.insertCell(4);
                let checkbox = document.createElement("input");
                checkbox.type = "checkbox";
                checkbox.onchange = () => completeOrder(index);
                cell4.appendChild(checkbox);
            });
        }
    });
}

function completeOrder(index){
    let orders = JSON.parse(localStorage.getItem("orders") || "[]");
    orders[index].status = "completed";
    localStorage.setItem("orders", JSON.stringify(orders));
    location.reload();
}
