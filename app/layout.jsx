import "@styles/globals.css";
import Nav from "@components/Nav.jsx";
import Provider from "@components/Provider";

export const metadata = {
  title: "Rebuttalk",
  description: "Discover & Share Your Ideas",
};
const RootLayout = ({ children }) => {
  return (
    <html lang="en">
      <body>
        <Provider>
          <Nav />
          <div>{children}</div>
        </Provider>
      </body>
    </html>
  );
};

export default RootLayout;
