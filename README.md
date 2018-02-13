# SalesTaxApplication
simple application which calculates sales tax and /or import tax

Each method was made to be changeable should the owner need to make changes such as filter and exemption
Filter uses a specific method to parse based on the "at" should this need to be changes the method for parsing could be edited
The exemption class reads from a file with keywords which determine if the item in the cart is exempt from the general sales tax

Futher improvements would be to improve the interface by creating a GUI for the user to simply type in in seperate columns the item they are
buying, and the quantity. Thus the program would determine the rest.

1 specific thing I noted within the pdf was the tax increase from 11.25 to 11.85. Given a 15% tax increase the amount of the tax added with the 15% would be .55 which would
leave the total to be 11.80. I remained with it being rounded to the 0.05 even though it doesn't align with the third output.

Lastly, the junit test file contains output 1 and output 2.