import Feed from "@components/Feed.jsx";

const Home = () => {
  return (
    <main>
      <section>
        <ul className="flex flex-col justify-center items-center">
          <li>
            <h1 className="text-center md:text-5xl sm:text-4xl text-3xl">
              Discover & Share your ideas
            </h1>
          </li>
          <li>
            <h2 className="text-2xl md:text-4xl sm:text-3xl  ">
              AI-Driven Prompts
            </h2>
          </li>
          <li>
            <p className="desc text-center">
              Rebuttalk is an open-source AI tool for discovering and sharing
              creativity.
            </p>
          </li>
        </ul>
      </section>

      <section>
        <Feed />
      </section>
    </main>
  );
};

export default Home;
