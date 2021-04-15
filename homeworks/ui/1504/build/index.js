"use strict";
var _a, _b, _c, _d;
var BinaryTreeNode = /** @class */ (function () {
    function BinaryTreeNode(data, key) {
        this.data = data;
        this.key = key;
        this.left = null;
        this.right = null;
    }
    BinaryTreeNode.prototype.getValue = function () {
        return this.data;
    };
    BinaryTreeNode.prototype.getKey = function () {
        return this.key;
    };
    return BinaryTreeNode;
}());
var BinaryTree = /** @class */ (function () {
    function BinaryTree() {
        this.head = null;
    }
    /*
     * Поиск минимума дерева
     */
    BinaryTree.prototype.minimum = function (root) {
        if (root == null) {
            return null;
        }
        return root.left ? this.minimum(root.left) : root;
    };
    /*
     * Поиск максимума дерева
     */
    BinaryTree.prototype.maximum = function (root) {
        if (root == null) {
            return null;
        }
        return root.right ? this.maximum(root.right) : root;
    };
    BinaryTree.prototype.search = function (root, key) {
        if (root == null || key == root.key) {
            return root;
        }
        if (key < root.key) {
            return this.search(root.left, key);
        }
        else {
            return this.search(root.right, key);
        }
    };
    BinaryTree.prototype.myInsertElement = function (root, data, key) {
        if (root == null) {
            return new BinaryTreeNode(data, key);
        }
        else {
            if (key < root.key) { // уходим в левое поддерево
                root.left = this.myInsertElement(root.left, data, key);
            }
            else { // уходим в правое поддерево
                root.right = this.myInsertElement(root.right, data, key);
            }
            return root;
        }
    };
    BinaryTree.prototype.myDeleteElement = function (root, key) {
        if (root == null) {
            return root;
        }
        if (key < root.key) {
            root.left = this.myDeleteElement(root.left, key);
        }
        else if (key > root.key) {
            root.right = this.myDeleteElement(root.right, key);
        }
        else if (root.left && root.right) {
            var rootKey = this.minimum(root.right);
            root.key = rootKey ? rootKey.key : Number.MIN_VALUE;
            root.right = this.myDeleteElement(root.right, root.key);
        }
        else {
            if (root.left) {
                root = root.left;
            }
            else if (root.right) {
                root = root.right;
            }
            else {
                root = null;
            }
        }
        return root;
    };
    /**
     * Добавление элемента в дерево
     */
    BinaryTree.prototype.insertElement = function (data, key) {
        this.head = this.myInsertElement(this.head, data, key);
    };
    /**
     * Удаление элемента с заданным ключом
     */
    BinaryTree.prototype.deleteElement = function (key) {
        this.head = this.myDeleteElement(this.head, key);
    };
    /**
     * Извлечение элемента по ключу
     */
    BinaryTree.prototype.searchElement = function (key) {
        var findData = this.search(this.head, key);
        return findData ? findData.data : null;
    };
    /**
     * Вывод всего дерева (I var)
     * Обход узлов в отсортированном порядке
     */
    BinaryTree.prototype.inorderTraversal = function (root) {
        if (root) {
            this.inorderTraversal(root.left);
            console.log(root.data + " ");
            this.inorderTraversal(root.right);
        }
    };
    /**
     * Вывод всего дерева (II var)
     * Обход узлов в порядке: вершина, левое поддерево, правое поддерево
     */
    BinaryTree.prototype.preorderTraversal = function (root) {
        if (root) {
            console.log(root.data + " ");
            this.preorderTraversal(root.left);
            this.preorderTraversal(root.right);
        }
    };
    /**
     * Вывод всего дерева (III var)
     * Обход узлов в порядке: левое поддерево, правое поддерево, вершина
     */
    BinaryTree.prototype.postorderTraversal = function (root) {
        if (root) {
            this.postorderTraversal(root.left);
            this.postorderTraversal(root.right);
            console.log(root.data + " ");
        }
    };
    BinaryTree.prototype.printTree = function () {
        console.log("Inorder traversal: ");
        this.inorderTraversal(this.head);
        console.log();
    };
    return BinaryTree;
}());
// -> main
var tree = new BinaryTree();
function clickInsVal() {
    var klue = document.getElementById("cellInsKlue").value;
    var val = document.getElementById("cellInsVal").value;
    tree.insertElement(val, Number(klue));
    console.log("Элемент добавлен " + klue + " " + val);
}
function clickDelVal() {
    var klue = document.getElementById("cellDelKlue").value;
    tree.deleteElement(Number(klue));
    console.log("Элемент удален " + klue);
}
function clickFindVal() {
    var klue = document.getElementById("cellFindKlue").value;
    console.log(klue);
    console.log(tree.searchElement(Number(klue)));
}
function clickPrintVal() {
    tree.printTree();
}
(_a = document.getElementById("cellButtonIns")) === null || _a === void 0 ? void 0 : _a.setAttribute("onclick", "clickInsVal()");
(_b = document.getElementById("cellButtonDel")) === null || _b === void 0 ? void 0 : _b.setAttribute("onclick", "clickDelVal()");
(_c = document.getElementById("cellButtonFind")) === null || _c === void 0 ? void 0 : _c.setAttribute("onclick", "clickFindVal()");
(_d = document.getElementById("cellButtonPrint")) === null || _d === void 0 ? void 0 : _d.setAttribute("onclick", "clickPrintVal()");
// tree.insertElement("a", 8);
// tree.insertElement("b1", 3);
// tree.insertElement("b2", 10);
// tree.insertElement("c1", 1);
// tree.insertElement("c2", 6);
// tree.insertElement("c4", 14);
// tree.insertElement("d3", 4);
// tree.insertElement("d4", 7);
// tree.insertElement("d5", 13);
// console.log(tree.searchElement(6));
// tree.printTree();
// tree.deleteElement(14);
// tree.printTree();
// tree.insertElement("d1", 0);
// tree.printTree();
