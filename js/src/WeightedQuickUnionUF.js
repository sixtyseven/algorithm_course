function WeightedQuickUnionUF(n) {
    this.parent = [];
    this.size = [];
    this._count = n;
    for (let i = 0; i < n; i++) {
        this.parent[i] = i;
        this.size[i] = 1;
    }
}

/**
 * Returns the number of sets.
 * @return int the number of sets
 */
WeightedQuickUnionUF.prototype.count = function () {
    return this._count;
}

/**
 * Returns the canonical element of the set containing element p
 *
 * @param p an element
 * @return the canonical element of the set containing p
 */
WeightedQuickUnionUF.prototype.find = function(p) {
    while(p !== this.parent[p]) {
        p = this.parent[p];
    }
    return p;
}

WeightedQuickUnionUF.prototype.connected = function (p, q) {
    return this.find(p) === this.find(q);
}

WeightedQuickUnionUF.prototype.union = function (p, q) {
    let rootP = this.find(p);
    let rootQ = this.find(q);
    if (rootP === rootQ) {
        return;
    }

    if (this.size[rootP] < this.size[rootQ]) {
        this.parent[rootP] = rootQ;
    } else {
        this.parent[rootQ] = rootP;
    }
    this._count--;
}

const uf = new WeightedQuickUnionUF(10);
uf.union(1, 10);
uf.union(2, 10);
uf.union(3, 10);
console.log(uf.count());
console.log(uf.connected(1,2));
console.log(uf.connected(3,2));
console.log(uf.connected(3,1));
console.log(uf.connected(3,4));



