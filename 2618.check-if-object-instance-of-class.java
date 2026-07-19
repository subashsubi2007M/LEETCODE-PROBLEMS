/**
 * @param {*} obj
 * @param {*} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    
    if (classFunction === null || classFunction === undefined || typeof classFunction !== 'function') {
        return false;
    }

    // Edge case: null and undefined don't have prototypes
    if (obj === null || obj === undefined) {
        return false;
    }

    
    let currentPrototype = Object.getPrototypeOf(Object(obj));

    // Traverse up the prototype chain
    while (currentPrototype !== null) {
        if (currentPrototype === classFunction.prototype) {
            return true;
        }
        currentPrototype = Object.getPrototypeOf(currentPrototype);
    }

    return false;
};
