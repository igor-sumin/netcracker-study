/**
 * Подсчет действительных корней квадратного уравнения
*/
function getRoots(a, b, c) {
    let D = b * b - 4 * a * c;

    if (a == 0) {
        if (b != 0) {
            return [-c / b, null];
        } else {
            return [null, null];
        }
    } else if (D == 0) {
        return [-b / (2 * a), null];
    } else if (D > 0) {
        let r1 = (-b + Math.sqrt(D)) / (2 * a);
        let r2 = (-b - Math.sqrt(D)) / (2 * a);

        return [r1, r2];
    } else {
        return [null, null];
    }
}

/**
 * Получение сообщения в поле "Получаем"
 */
function getMsg(r1, r2) {
    if (r1 && r2) {
        return "два корня уравнения: x&#8321; = " + r1 + ", x&#8322; = " + r2;
    } else if (r1) {
        return "один корень уравнения: x = " + r1;
    } else {
        return ", что действительных корней нет";
    }
}

/**
 * Заполнение таблицы корнями квадратного уравнения
 */
function setRootsTable(r1, r2) {
    let tbody = document.getElementById("hist_table").getElementsByTagName("tbody")[0];

    let row = document.createElement("tr");
    let left = document.createElement("td");
    let right = document.createElement("td");

    row.setAttribute("onclick", "rowDelete(this)");

    tbody.appendChild(row);
    row.appendChild(left);
    row.appendChild(right);

    if (r1 || r2) {
        left.innerHTML  = r1;
        right.innerHTML = r2;
    } else {
        left.innerHTML  = "действительных";
        right.innerHTML = "корней нет";
    }
}

/**
 * Удаление выбранной строки из таблицы
 */
function rowDelete(link) {
    link.remove();
}

/**
 * Работа функций при взаимодействии с пользователем
 */
cell_button.onclick = function() {
    let a = document.getElementById("cell_1").value;
    let b = document.getElementById("cell_2").value;
    let c = document.getElementById("cell_3").value;

    let [first_root, second_root] = getRoots(a, b, c);
    document.getElementById("get_roots").innerHTML = getMsg(first_root, second_root);
    setRootsTable(first_root, second_root);
}