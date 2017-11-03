interface DataProvider<T, U> {
    /**
     * Returns the value associated with the specified key.
     * @param key the key
     * @return the value associated with the key
     */
    U get (T key);
}
