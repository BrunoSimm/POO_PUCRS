#!/bin/bash

printf "# Checking software availability\n";

# Check for Java
printf "  ";
if [ `which java` ]; then printf "✅";
else printf "❌"; fi
printf " Java\n";

# Check for Maven
printf "  ";
if [ `which mvn` ]; then printf "✅";
else printf "❌"; fi
printf " Maven\n";

# Check for NodeJS
printf "  ";
if [ `which node` ]; then printf "✅";
else printf "❌"; fi
printf " NodeJS\n";

# Check for NPM
printf "  ";
if [ `which npm` ]; then printf "✅";
else printf "❌"; fi
printf " NPM\n";

# Check for Angular
printf "  ";
if [ `which ng` ]; then printf "✅";
else printf "❌"; fi
printf " Angular\n";

# Check for Git
printf "  ";
if [ `which git` ]; then printf "✅";
else printf "❌"; fi
printf " Git\n";

# Check for cURL
printf "  ";
if [ `which curl` ]; then printf "✅";
else printf "❌"; fi
printf " cURL\n";

# Check for Wget
printf "  ";
if [ `which wget` ]; then printf "✅";
else printf "❌"; fi
printf " Wget\n";

printf "\n"