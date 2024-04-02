"use client";
import Link from "next/link";
import { useState, useEffect } from "react";
import { signIn, signOut, useSession, getProviders } from "next-auth/react";
import { FaUserCircle } from "react-icons/fa";
import { BiMenu } from "react-icons/bi";

const Nav = () => {
  const isUserLoggedIn = true;
  return (
    <header>
      <aside>
        <Link href="/">Logo</Link>
      </aside>

      <nav>
        {isUserLoggedIn ? <DestopScreen /> : <UserNotLoggedIn />}

        {isUserLoggedIn ? <MobileScreen /> : <UserNotLoggedIn />}
      </nav>
    </header>
  );
};

//User not logged in
function UserNotLoggedIn() {
  const [providers, setProviders] = useState(null);

  useEffect(() => {
    const setProviders = async () => {
      const response = await getProviders();
      setProviders(response);
    };
    setProviders();
  }, []);

  return (
    <>
      {providers &&
        Object.values(providers).map((provider) => (
          <button key={provider.name} onClick={() => signIn(provider.id)}>
            Sign In
          </button>
        ))}
    </>
  );
}

// Desktop Responsive View
function DestopScreen() {
  return (
    <div className="md:flex hidden items-center gap-2 ">
      <Link
        href="/createPrompt"
        className="createButton py-2 px-5 text-sm font-medium focus:outline-none rounded-lg">
        Create Post
      </Link>
      <button
        onClick={() => signOut}
        className="signoutButton py-2 px-2 text-sm font-medium focus:outline-none rounded-lg">
        Signout
      </button>
      <Link href={"/Profile"}>
        <FaUserCircle className=" text-3xl " />
      </Link>
    </div>
  );
}

// Mobile Responsive View
function MobileScreen() {
  const [toggleDropDown, setToggleDropDown] = useState(false);
  return (
    <div className="sm:hidden flex relative">
      <button
        onClick={() => setToggleDropDown((toggle) => !toggle)}
        className=" py-2 px-2 text-sm font-medium focus:outline-none rounded-lg">
        <BiMenu color="white" size={35} />
        {toggleDropDown && (
          <div className="mobileDropdown p-2 absolute divide-y right-1 top-12 w-40 rounded-lg flex flex-col">
            <Link
              href="/Profile"
              className="dropdownlist flex justify-center py-2 px-5 text-sm font-medium focus:outline-none ">
              <FaUserCircle className="text-3xl" />
            </Link>

            <Link
              href="/createPrompt"
              onClick={() => setToggleDropDown(false)}
              className="dropdownlist text-left py-2 px-5 text-sm font-medium focus:outline-none ">
              Create Post
            </Link>

            <button
              className="dropdownlist rounded-lg text-left py-2 px-5 text-sm font-medium focus:outline-none "
              onClick={() => {
                setToggleDropDown(false);
                signOut();
              }}>
              Sign Out
            </button>
          </div>
        )}
      </button>
    </div>
  );
}

export default Nav;
