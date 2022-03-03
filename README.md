<h1>Project Zero</h1>
<h6>Alex Nagel</h6>
<br><br>
<h2>Requirements of project</h2>
<div>
<p>*Store data in a database</p><p>Custom procedure is called</p><p>*Data access is done through use of JDBC with Data Objects</p><p>*Inputs received through Scanner Class</p><p>*JUnit test is written for some functionality</p>
</div>
<br><br>
<h2>All User's Functionality</h2>
<div>
<p>*Users can log in</p><p>*Users can create account</p>
</div>
<br>
<h3>My results of this section</h3>
<div>
<p>I was able to successfully implement both of these. Logging in is done with a username which a user creates and must be unique compared to rest of database. Creating an account gives the user a unique accountNumber tied to them, to be used as the primary key for the Login database table.</p>
<p>For testing sake, I allowed user to sign in regardless. But it will check if the username and password matches, printing a message that it was incorrect. By default, new customers had a balance of $10,000 to test with. For the sake of this project, I will keep it this way. Though it would be doable and an option to have user 'deposit' an initial starting amount.</p>
</div>
<br>
<h3>Customer's Functionality</h3>
<div>
<p>*Customers can apply for new account with starting balance</p><p>*Customers can view their balance</p><p>*Customers can make withdrawal or deposit to their account</p><p>*Customers can post money to transfer to another account</p><p>Customers can receive money transfer from another account</p>
</div>
<br>
<h3>My results of this section</h3>
<div>
<p>Creation was done at the Login stage, defaulting with a balance. I did not get to the area dedicated to approval or reject account, but that will be discussed under employee functionality section. Viewing balance was also completed. User can go below zero, and this is intentional. What I did not implement but wanted to is a fee to occur for the first withdrawal that brings user below zero; if the user had $50 and took out $50, they would have $0. However, taking out an additional $1 would put a charge of $35 on their account, placing them at -$36 and be unable to withdraw anymore until deposit above zero.</p><p>I created a table called transfers that would hold all incoming and outgoing transfers. This is so employees can see a list of transfers and approve or deny as necessary. This is where I intended to use a procedure, which I do have created but did not want to use until I confirmed it worked okay. I failed to implement receiving money, and I am unsure why exactly. A customer can log in and search for a list of all transfers for them. I intended for the customer themselves to not be able to accept them, as that job would be dedicated to the employee. If there are no transfers incoming then a message does print indicating so. I was able to confirm after debugging that it can find transfers in the database, but I could not get the program to print off the required information.</p>
</div>
<br>
<h3>Employee's Functionality</h3>
<div>
<p>Employees can approve or reject accounts</p><p>Employees can view customer's bank accounts</p><p>Employees can see all transactions</p>
</div>
<br>
<h3>My results of this section</h3>
<div>
<p>This section was lowest on my priority. Logging in and Customers seemed most pressing to me, as an online banking experience is primarily for the customer and what I personally have experience with. Additionally, every aspect of employee relies on customers' interactions, so without a valid and functional customerDAO it would be pointless.</p><p>I still made efforts in preparation of utilizing an employeeDAO. Under Login in the table, there is a column dedicated to indicating if the user is a customer or an employee, which would result in giving different menus. The Employee menu was created as well, but no usage as of this moment. With an Employee account, they would be able to see all created accounts that are customers, then would be able to delete that row in the database as required. With each customer having an accountNumber, an employee could enter a unique serial integer or unique username to pull up the balance of that customer. Within the Transfers table there is a transferID. The employee would have access to see all transfers with the transferID, accountSender, accountReceiver, and amount. The employee would approve or reject based on the transferID.</p>
</div>
<br><br>
<h2>Afterthought</h2>
<div>
<p>I attempted to segregate the information as much as possible into separate tables for security and organization, but that may have caused some complications. I would have used joins in postgres to check the Login to either Customers or Employees, and Customers to Transfers. I wanted to deal with procedure last, even though that is incredibly inefficient. My logic was that I wanted to be able to hardcode with JDBC sample transactions for testing, but this may have been the wrong course of action. Had I created a procedure and utilized them for key areas, such as transfers, I would have reduced my workload a lot and create a clearer image to work with. The JUnit testing I tried was with withdraw and deposit, which prompt me to create new constructors to have the correct parameters to work with that I actually needed to test. I was able to create a format that appeared correct, but I could not get a satisfactory output. I have attempted on every aspect of project zero, whether it be with Java, JDBC, postgres, or a combination of these. I displayed a fundamental grasp of what we were taught.</p>
</div>




<br><br><br><br>*Asterisk indicates completed