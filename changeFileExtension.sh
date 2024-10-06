#!/bin/bash

# Find all .java files in the current directory and subdirectories
for file in $(find . -type f -name "*.java"); do
    # Get the base name without extension
    baseName=$(basename "$file" .java)

    # Get the directory path of the file
    dirName=$(dirname "$file")

    # Rename the file to .txt extension
    mv "$file" "$dirName/$baseName.txt"
done
