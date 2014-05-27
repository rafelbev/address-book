address-book
============

Pet project
ConsoleTest implements:
  * How many males are in the address book?
  * Who is the oldest person in the address book?

CompareEntryTest implements:
  * How many days older is Bill than Paul?

Spring batch was used since it will scale well if the size of the address book is large and no database indexing is available to find the solution of the tasks.
The Writers can be integrated into one to avoid doing two passes on the address book to solve the first two tasks.