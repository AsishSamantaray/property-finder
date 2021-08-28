const Properties = ({ properties }) => {
  return (
    <div>
      <h1>{properties[0].fullAddress}</h1>
    </div>
  );
};

export default Properties;

export const getStaticProps = async () => {
  const res = await fetch("http://localhost:8080/api/properties");
  const data = await res.json();

  return {
    props: {
      properties: data,
    },
  };
};
